package com.microservices.product.service;

import com.microservices.product.dtos.ProductForListResponseDTO;
import com.microservices.product.dtos.ProductRequestDTO;
import com.microservices.product.dtos.ProductResponseDTO;
import com.microservices.product.entities.Product;
import com.microservices.product.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{

    private final IProductRepository productRepository;

    @Override
    public void saveProduct(ProductRequestDTO productRequestDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productRequestDTO, Product.class);
        productRepository.save(product);

    }

    @Override
    public ProductResponseDTO findByName(String name) {
        Product product = productRepository.findByName(name);
        ModelMapper modelMapper = new ModelMapper();
        ProductResponseDTO productResponseDTO = modelMapper.map(product, ProductResponseDTO.class);
        return productResponseDTO;
    }

    @Override
    public List<ProductForListResponseDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(product -> modelMapper.map(product, ProductForListResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void updateProduct(ProductRequestDTO productRequestDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = productRepository.findByName(productRequestDTO.getName());
        if(product != null){
            productRepository.save(modelMapper.map(productRequestDTO, Product.class));
        }else{
            throw new RuntimeException("Product not found by name");
        }
    }

    @Override
    public void delete(Long id) {

        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }else{
            throw new RuntimeException("Product with id: "+ id + " not found.");
        }

    }

    @Override
    public List<ProductForListResponseDTO> findByCategory(String category) {
        List<Product> productList = productRepository.findByCategory(category);
        ModelMapper modelMapper = new ModelMapper();
        return productList.stream()
                .map(product -> modelMapper.map(product, ProductForListResponseDTO.class)).collect(Collectors.toList());
    }
}
