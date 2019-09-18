
<!DOCTYPE html>
<html>
<head>
<title>Grade Management system</title>
<link rel="icon" href="images/gms-logo.png" type="image/x-icon">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
function msg()  
{  
	 $("#myModal").modal();
}  
</script>
<script>
function login(){
    event.preventDefault();
    var name = document.getElementById("name").value;
    var fathername = document.getElementById("fathername").value;
  	var email = document.getElementById("email").value;
    var department = document.getElementById("department").value;
    var formData ="name=" + name + "&fathername=" + fathername+ "&email=" + email + "&department=" + department;
    console.log(formData);
var url ="http://localhost:8080/web/FrontController/addEmployee.do?"+ formData;
    $.get(url, function(response){
        console.log(response);
       var data=JSON.parse(response);
       if(data!=null){
       if(data.roles)
           {
           window.location.href="AdminLogin.jsp";
           }
       else
           {
           console.log("user login");
           window.location.href="UserLogin.jsp";
           }
       }
       else
           {
			document.getElementById("loginmsg").innerHTML="<b><i>Access Denied! Invalid credentials</i></b>";
           }

     });
    }

</script>
</head>
<body>
	<jsp:include page="AdminLogin.jsp"></jsp:include>

	<div id="myModal" class="modal fade">
		<div class="modal-dialog modal-login">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Sign In</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div id="loginmsg" align=center style="color: red;"></div>
					<form method="post" onsubmit="AddNewEmployee()">
						<div class="form-group">
							<input type="text" class="form-control" name="name"
								id="name" placeholder="employee name" required="required">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="fathername"
								id="fathername" placeholder="employee father name" required="required">
						</div>
						<div class="form-group">
							<input type="email" class="form-control" name="email" id="email"
								placeholder="email" required="required">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="department" id="department"
								placeholder="department" required="required">
						</div>
						<div class="form-group" align=center>
							<button type="submit" class="btn btn-primary btn-xs">Sign
								In</button>
							&nbsp
							<button type="reset" class="btn btn-primary btn-xs">clear</button>
						</div>					
					</form>
				</div>			
			</div>
		</div>
	</div>
</body>
<script>msg();</script>
</html>