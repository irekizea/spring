<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <h1> 결제해결제해</h1>

    <form action="confirm" method = "post">
    	<input type = "text" name = "partner_order_id"><br>
    	<input type = "text" name = "Partner_user_id" ><br>
    	<input type = "text" name = "item_name" ><br>
    	<input type = "text" name = "quantity"><br>
    	<input type = "text" name = "total_amount"><br>
    	<input type = "text" name = "vat_amount"><br>
		<input type = "text" name = "tax_free_amount"><br>  
		<input type ="submit" value = "제출" >	
    </form>