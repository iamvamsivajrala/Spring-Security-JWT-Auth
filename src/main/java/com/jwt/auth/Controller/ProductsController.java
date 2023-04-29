package com.jwt.auth.Controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.auth.Exception.CustomException;
import com.jwt.auth.Exception.UserNameException;
import com.jwt.auth.JwtToken.JwtTokenProvider;
import com.jwt.auth.dto.LoginDto;
import com.jwt.auth.dto.StrToJsonJwt;
import com.jwt.auth.entity.Products;
import com.jwt.auth.entity.UsersData;
import com.jwt.auth.repo.UsersRepo;
import com.jwt.auth.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/welcome")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String home() {
		return ("welcome to the home page");
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Products> allProducts() {
		return productService.totalproducts();
	} 
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_MODERATOR')")
	public Products findById(@PathVariable int id) {
		return productService.findByid(id);
	}
	
	@PostMapping("/save")
	public UsersData saving(@RequestBody UsersData usersData) {
		
		usersData.setPassword(passwordEncoder.encode(usersData.getPassword()));
		return usersRepo.save(usersData);
	}
	
	
	
	
	
	
	
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<StrToJsonJwt> loginUser(@RequestBody LoginDto loginDto){
		
		
		
			//throws error when usersRepo does not have any object with logindto.getname() 
			usersRepo.findByName(loginDto.getName()).orElseThrow(()->new UserNameException("wrong username"));
		
		org.springframework.security.core.Authentication authentication=authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getName(), loginDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		
		
		String token=jwtTokenProvider.generateToken(authentication);
		
		return  new ResponseEntity<>(new StrToJsonJwt(token),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
