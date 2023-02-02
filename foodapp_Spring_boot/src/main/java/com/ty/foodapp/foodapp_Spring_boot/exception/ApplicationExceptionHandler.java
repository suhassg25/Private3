package com.ty.foodapp.foodapp_Spring_boot.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundIdException.class)
	public ResponseEntity<ResponseStructure<String>> notFound(NotFoundIdException exception) {
		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(exception.getMessage());

		return entity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnableToUpdateException.class)
	public ResponseEntity<ResponseStructure<String>> UpdateExceptionHandler(UnableToUpdateException exception) {
		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Not Found");
		responseStructure.setData(exception.getMessage());
		return entity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnbaleToDeleteException.class)
	public ResponseEntity<ResponseStructure<String>> deleteExceptionHandler(UnbaleToDeleteException exception) {
		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id not Found");
		responseStructure.setData(exception.getMessage());
		return entity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (ObjectError er : errors) {
			String message = er.getDefaultMessage();
			String fieldname = ((FieldError) er).getField();
			map.put(fieldname, message);
		}
		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<Map<String, String>>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("Values not found");
		responseStructure.setData(map);
		return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);

	}

}
