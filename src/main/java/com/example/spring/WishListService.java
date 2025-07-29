package com.example.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WishListService {
    WishListRepository wishListRepository;
    ProductRepository productRepository;

    public WishListService(WishListRepository wishListRepository, ProductRepository productRepository) {
        this.wishListRepository = wishListRepository;
        this.productRepository = productRepository;
    }

    public WishListDto addWishList(ProductDto productDto) {
        Product product = productRepository.findByName(productDto.productName())
                .orElseThrow(()-> new NoSuchElementException("해당되는 Product가 없습니다."));
        WishList wishList = new WishList(product);
        WishList savedWishList = wishListRepository.save(wishList);
        WishListDto wishListDto = new WishListDto(savedWishList.getProductName());
        return wishListDto;
    }

    public List<WishListDto> getAllWishList() {
        List<WishList> wishLists = wishListRepository.findAll();
        List<WishListDto> wishListDtoList = new ArrayList<>();
        for(WishList wishList : wishLists){
            WishListDto wishListDto = new WishListDto(wishList.getProductName());
            wishListDtoList.add(wishListDto);
        }
        return wishListDtoList;
    }
}
