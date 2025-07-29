package com.example.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WishListController {
    private final WishListService wishListService;
    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }
    @PostMapping("/wishList")
    public ResponseEntity<WishListDto> addWishList(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(wishListService.addWishList(productDto));
    }
    @GetMapping("/wishList")
    public ResponseEntity<List<WishListDto>> getAllWishList() {
        return ResponseEntity.ok(wishListService.getAllWishList());
    }
}
