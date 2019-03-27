<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/styles.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
function handleSelect(elm)
{
window.location = elm.value;
}
</script>
</head>
<body>
        <nav class="navbar navbar-expand-md navbar-light bg-light">
                <img src=""></img>
                                 
                    <form class="mx-2 my-auto d-inline w-20">
                        <div class="input-group">
                            <input type="text" class="form-control form-rounded border border-right-0" placeholder="Search...">
                            <span class="input-group-append">
                            <button class="btn btn-outline-secondary border border-left-0" type="button">
                                <i class="fa fa-search"></i>                              
                            </button>
                          </span>
                        </div>
                    </form>

               <ul class="navbar-nav ml-auto">
                   <li class="nav-item">
                       <a class="nav-link" href="#"><span class="fa fa-bell"></span></a>
                   </li>
                   <li class="nav-item">
                       <span class="navbar-text">
                           Welcome, ${user.firstName}
                       </span>
                   </li>
                   </ul>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <form class="mx-2 my-auto w-full">
                               <a href="logout.html" class="btn btn-secondary  form-rounded" >Logout
           
            </a>
                            </form>
                        </li>
                    </ul>
                        
            </nav>

<div class="container-fluid">
    <div class="row">
            <div class="col-md-3 bg-light">
                <nav class="navbar navbar-expand-md navbar-dark bg-secondary">
                    <span class="navbar-text navbar-">PROFILE</span>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a href="" style="color: aliceblue">Edit</a>
                        </li>
                    </ul>
                </nav>

<br><center>
    <picture>
        <img src="https://firebasestorage.googleapis.com/v0/b/grizzly-5a659.appspot.com/o/profile.png?alt=media&token=2c04d156-e6da-41c5-b726-e7301f660ac1" alt="Profile picture" width="50px"></img>
    </picture><br>
    <b>${user.firstName}</b>
<br><br>
ID: <br> ${user.userId}
<br><br><br>
<form class="mx-2 my-auto w-full">
    <button class="btn btn-secondary form-rounded" type="button">Contact US</button>
</form>
</center>
  </div>

                <div class="col-md-9 bg-light">
            
                    <div class="btn-group col-md-12">
                        <div class="container">
                            
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs" role="tablist">
                              <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#home">MEDICINES</a>
                              </li>
                              <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#menu1">DOCTORS</a>
                              </li>
                             <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#menu2">BLOOD BANK</a>
                              </li>
                            </ul>
                          
                            <!-- Tab panes -->
                            <div class="tab-content">
                              <div id="home" class="container tab-pane active"><br>
        
                        <div class="col-md-12 bg-light">
                                <form class="mx-2 my-auto d-inline w-20" action="search.html" method="POST">
                                        <div class="input-group">
                                            <input list="category" name="browser" class="form-rounded" placeholder="Search By">
                                            <datalist id="category">
                                              <option value="Salt Name" selected>Salt Name</option>
                                              <option value="Medicine Name">Medicine Name</option>
                                              <option value="Brand">Brand</option>
                                             </datalist>    


                                                    &emsp;&nbsp;&nbsp;
                                                    <input type="text" name="category" class="form-rounded border border-right-0" placeholder="Salt/Medicine/Brand">
                                                    <span class="input-group-append">
                                                    <button class="btn btn-outline-secondary border border-left-0" type="submit">
                                                        <i class="fa fa-search"></i>                              
                                                    </button>
                                                  </span>
                                                  &emsp;&emsp;
                                                      <select name="select-city" onchange="location = this.value;">
<option value="">Select-Sorting Type</option>
 <option value="hightolow.html?order=LowToHigh">Low To High</option>
 <option value="hightolow.html?order=HighToLow">High To Low</option>
</select>  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</form>
                                   
                        </div>
    
                                     <br>                     
                                     <table border="1" class="table table-bordered">
                                            <tr>
                                                <td>
                                                    <center><span style="color: gray">ID</span>
                                                </td>
                                                <td>
                                                    <center> <span style="color: gray">Medicine Name</span>
                                                </td>

                                                <td>
                                                        <center> <span style="color: gray">Brand</span>
                                                    </td>
                                                    <td>
                                                            <center><span style="color: gray">Salt Name</span>
                                                        </td>
                                                        <td>
                                                                <center><span style="color: gray">Price</span>
                                                            </td>
                                                            <td>
                                                                    
                                                                </td>
                                            </tr>
                                    <c:forEach  var="medicines"  items= "${medicines}">
                        <tr>
                          <td>
                            <div class="checkbox checkbox-info checkbox-circle">
                              
                              <label for="checkbox11">
                                ${medicines.medId}
                              </label>
                            </div>    
                          </td>
                          <td>
                            ${medicines.medName}
                          </td>
                          <td>
                            ${medicines.brand}
                          </td>
                          <td>
                            ${medicines.saltName}
                            
                          </td>
                          <td>
                          
                            ${medicines.price}
                            
                          </td>
                          <td>
                            <center>
                              <a href="#" class="btn btn-secondary form-rounded"  width="50px"> &emsp;Manage&emsp; 
                              </a>&emsp;&emsp;
							
                            </center>
                          </td>
                        </tr>
                       </c:forEach>  
                                           
                                        </table>

                        </div>
                              </div>
                              
                              <div id="menu1" class="container tab-pane fade"><br>
                               <a href="showdoctorlist.html?id=${doctor.userId}" class="btn btn-secondary form-rounded"  width="50px"> Show Doctors List 
                              </a>
                              </div>
                             
                             
                             
                             
                              <div id="menu2" class="container tab-pane fade"><br>
                                   <a href="showbloodlist.html" class="btn btn-secondary form-rounded"  width="50px"> Show Blood Bank 
                              </a>  
                              </div>
                            </div>
                          </div>
                    </div>
                    <br>
    </div>    

           
</body>
</html>