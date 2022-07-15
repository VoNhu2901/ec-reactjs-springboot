package com.example.assignment.services.impl;

import com.example.assignment.data.entities.Category;
import com.example.assignment.data.entities.Product;
import com.example.assignment.data.entities.ProductImage;
import com.example.assignment.data.repositories.CategoryRepository;
import com.example.assignment.data.repositories.ProductImageRepository;
import com.example.assignment.data.repositories.ProductRepository;
import com.example.assignment.dto.request.ProductCreateDto;
import com.example.assignment.dto.response.ProductResponseDto;
import com.example.assignment.dto.response.ProductSimpleResponseDto;
import com.example.assignment.exceptions.ResourceNotFoundException;
import com.example.assignment.services.ProductService;
import com.example.assignment.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public List<ProductResponseDto> getAllProduct() {
        List<Product> productList = this.productRepository.findAll();
        List<ProductResponseDto> result = new ArrayList<>();
        for (Product product : productList) {
            ProductResponseDto newProduct = modelMapper.map(product, ProductResponseDto.class);
            // calculate rating of product
            newProduct.setRate(Utils.rate(product.getProductRates()));
            result.add(newProduct);
        }
        return result;
    }

    @Override
    public ProductResponseDto getProductById(int id) {
        Optional<Product> productOptional =  this.productRepository.findById(id);
        if(productOptional.isPresent()){
            Product product  = productOptional.get();
            ProductResponseDto res = new ProductResponseDto();
            modelMapper.map(product, res);
            res.setRate(Utils.rate(product.getProductRates()));
            return res;
        }
        throw new ResourceNotFoundException(Utils.PRODUCT_NOT_FOUND);
    }

    @Override
    public List<Product> getProductByRate() {
        return null;
    }
    @Override
    public List<ProductSimpleResponseDto> getProductByCategory(int cateId) {
        Category category = this.categoryRepository.findById(cateId).orElseThrow(ResourceNotFoundException::new);

        List<ProductSimpleResponseDto> result = new ArrayList<>();
        List<Product> listProduct = this.productRepository.findByCategoryAndStatus(category, true);
        for (Product product : listProduct) {
            ProductSimpleResponseDto res = new ProductSimpleResponseDto();
            result.add(res.build(product));
        }
        return result;
    }

    @Override
    public List<ProductSimpleResponseDto> getProductOnTrading() {
        List<Product> productList = this.productRepository.findByStatus(Utils.PRODUCT_TRADING);
        if (productList.isEmpty()) {
            throw new ResourceNotFoundException(Utils.NO_PRODUCT);
        }

        List<ProductSimpleResponseDto> result = new ArrayList<>();
        for (Product product : productList) {
            ProductSimpleResponseDto res = new ProductSimpleResponseDto();
            result.add(res.build(product));
        }
        return result;
    }

    private void saveImage(Product pro, String[] list) {
        for (String url : list) {
            ProductImage temp = new ProductImage();
            temp.setImgUrl(url);
            temp.setProduct(pro);
            this.productImageRepository.save(temp);
        }
    }

    @Override
    public ProductResponseDto createNewProduct(ProductCreateDto productCreateDto) {

        // get category
        Category category = this.categoryRepository.findById(productCreateDto.getCategoryId())
                .orElseThrow(ResourceNotFoundException::new);

        Product newProduct = new Product();
        newProduct.setCategory(category);
        newProduct.setName(productCreateDto.getName());
        newProduct.setDescription(productCreateDto.getDescription());
        newProduct.setAmount(productCreateDto.getAmount());
        newProduct.setPrice(productCreateDto.getPrice());
        newProduct.setStatus(Utils.PRODUCT_TRADING);
        Product saveProduct = this.productRepository.save(newProduct);

        // save image
        saveImage(saveProduct, productCreateDto.getImages());

        return modelMapper.map(getProductById(saveProduct.getProId()), ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto deleteProduct(int proId) {
        Optional<Product> productOptional = this.productRepository.findById(proId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            Boolean tempStatus = product.getStatus();
            product.setStatus(!tempStatus);

            product = this.productRepository.save(product);
            return modelMapper.map(product, ProductResponseDto.class);

        }

        throw new ResourceNotFoundException(Utils.PRODUCT_NOT_FOUND);
    }

    @Override
    public ProductResponseDto updateProduct(int id, ProductCreateDto productCreateDto) {
        Optional<Product> productOptional = this.productRepository.findById(id);
        Category category = this.categoryRepository.findById(productCreateDto.getCategoryId())
                .orElseThrow(ResourceNotFoundException::new);

        if (productOptional.isPresent()) {
            Product pro = productOptional.get();
            pro.setCategory(category);
            pro.setName(productCreateDto.getName());
            pro.setDescription(productCreateDto.getDescription());
            pro.setAmount(productCreateDto.getAmount());
            pro.setPrice(productCreateDto.getPrice());
            Product newProduct = this.productRepository.save(pro);

            // save change image
            saveImage(newProduct, productCreateDto.getImages());

            return modelMapper.map(newProduct, ProductResponseDto.class);

        }
        throw new ResourceNotFoundException(Utils.PRODUCT_NOT_FOUND);
    }
}
