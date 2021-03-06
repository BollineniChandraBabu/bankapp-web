
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
function AddNewStudent(){
    event.preventDefault();
    var name = document.getElementById("name").value;
    var fathername = document.getElementById("fathername").value;
  	var dob = document.getElementById("dob").value;
    var department = document.getElementById("department").value;
    var address = document.getElementById("address").value;
    var formData ="name=" + name + "&fathername=" + fathername+ "&dob=" + dob + "&department=" + department+ "&address=" + address;
    console.log(formData);
var url ="http://localhost:8080/web/FrontController/addStudent.do?"+ formData;
    $.get(url, function(response){
        console.log("AddNewstudent:"+response);
       var data=JSON.parse(response);
       if(data!=null){
			document.getElementById("registermsg").innerHTML="successfully added.....<br><b>Student ID:"+data;
           }

     });
    }


function checkDepartment(){
    event.preventDefault();
  	var department = document.getElementById("department").value;
    var formData ="department=" + department;
    console.log(formData);
var url ="http://localhost:8080/web/FrontController/checkDepartment.do?"+ formData;
    $.get(url, function(response){
       var data=JSON.parse(response);
       if(data.result==false){
    	   document.getElementById("registermsg").innerHTML="department doesn't exist....";
    	   document.getElementById("department").focus();
       }
       else
           {
    	   document.getElementById("registermsg").innerHTML="";
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
					<h4 class="modal-title">Add New Student</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div id="registermsg" align=center style="color: red;"></div>
					<form method="post" onsubmit="AddNewStudent()">
						<div class="form-group">
							<input type="text" class="form-control" name="name"
								id="name" placeholder="Student name" required="required">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="fathername"
								id="fathername" placeholder="Student father name" required="required">
						</div>
						<div class="form-group">
							<input type="date" class="form-control" name="dob" id="dob"
								 required="required">
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="department" id="department"
								placeholder="department" required="required" onfocusout="checkDepartment()">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="address" id="address"
								placeholder="enter student address" required="required">
						</div>
						
						<div class="form-group" align=center>
							<button type="submit" class="btn btn-primary btn-xs">submit</button>
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