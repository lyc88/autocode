package com.example.demo.test.entity;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lyc on 2019/5/31.
 * https://blog.csdn.net/qq_38439885/article/details/81227063
 * https://my.oschina.net/u/2552286/blog/854491
 */
public class DateTimeConstraintValidator implements ConstraintValidator<DateTime, String> {


   private boolean require = false;

   @Override
   public boolean isValid(String obj, ConstraintValidatorContext context) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      boolean flag = (obj == null);
      try {
         simpleDateFormat.parse(obj);
      }catch (Exception e){
         return false;
      }
      return !flag;
   }

   @Override
   public void initialize(DateTime constraintAnnotation) {
      require = constraintAnnotation.required();
   }

 /*  @Override
   public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {

      return false;
   }*/
}
