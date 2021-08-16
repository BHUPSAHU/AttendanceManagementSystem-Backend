package com.ams.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<?> recordNotFoundException(CourseNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"RecordNotFoundException : \n"+ ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	
	
	@ExceptionHandler(AssignFacultyNotFoundException.class)
    public ResponseEntity<?> assignFacultyNotFoundException(AssignFacultyNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"AssignFacultyNotFoundException : \n"+ ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	
	@ExceptionHandler(AttendanceNotFoundException.class)
    public ResponseEntity<?> attendanceNotFoundException(AttendanceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"AttendanceNotFoundException : \n"+ ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	
	@ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> studentNotFoundException(StudentNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"StudentNotFoundException : \n"+ ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	
	@ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<?> subjectNotFoundException(SubjectNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"SubjectNotFoundException : \n"+ ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(UserNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"UserNotFoundException : \n"+ ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	
	@ExceptionHandler(Exception.class) 
	  public ResponseEntity<?> globalExcpetionHandler(Exception ex, WebRequest request) {
		 ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"Exception \n: "+ ex.getMessage() ,request.getDescription(false)); 
		 return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}