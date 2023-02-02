package com.ty.foodapp.foodapp_Spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp.foodapp_Spring_boot.dao.ProductDao;
import com.ty.foodapp.foodapp_Spring_boot.dto.Product;
import com.ty.foodapp.foodapp_Spring_boot.exception.NotFoundIdException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnableToUpdateException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnbaleToDeleteException;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseEntity<ResponseStructure<Product>> entity;
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveProduct(product));
		return entity = new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, int id) {
		ResponseEntity<ResponseStructure<Product>> entity;
		Product p = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		if (p != null) {
			
			product.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateProduct(product));
		} else {
			throw new UnableToUpdateException();
		}

		return entity = new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		ResponseEntity<ResponseStructure<String>> entity;
		Product p = dao.getProductById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (p != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(dao.deleteProductById(id));
		} else {
			throw new UnbaleToDeleteException();
		}
		return entity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> getById(int id) {
		ResponseEntity<ResponseStructure<Product>> entity;
		Product p = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (p != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.getProductById(id));
		} else {
			throw new NotFoundIdException();
		}
		return entity = new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
	}

}
