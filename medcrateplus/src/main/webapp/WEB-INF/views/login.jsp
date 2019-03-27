<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Admin-Login</title>
                
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/styles.css">
        <script type="text/javascript">
        window.history.forward();
        function noBack(){
        	history.pushState(null,null,document.URL);
        	window.addEventListener('popstate', function(){
        		history.pushState(null,null,document.URL);
        	});
        }
        </script>
    </head>


    <body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onunload="noBack();">
    
       <br><br><br><br>
        <center><img src="" />
  
    <br><br>
    <form  action="login.html" method="POST">
            <div class="form-group row topnav1 ">
                    <label for="fname" class="col-sm-5 col-form-label"></label>
                    <div class="col-sm-2">
        <input type="text" name="userId" placeholder="Username" class="form-control form-rounded" id="userId" required > 
    </div>
   </div>
            <div class="form-group row topnav1 ">
                    <label for="fname" class="col-sm-5 col-form-label"></label>
                    <div class="col-sm-2">
        <input type="password" name="password" placeholder="Password" class="form-control form-rounded" id="password" required > 
    </div>
   </div>

<div class="form-group row">
        <label for="zip" class="col-sm-5 col-form-label"></label>
        <div class="col-sm-2">
                <input type="submit" class="btn btn-secondary form-rounded" value="Login">
            </div>
</div>
  

    </form>
    </body>
</html>