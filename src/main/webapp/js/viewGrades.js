
function viewGrade(){
    event.preventDefault();
    var url ="http://localhost:8080/web/FrontController/viewgrade.do";
    $.get(url, function(response){
        console.log(response);
       var data=JSON.parse(response);
       var content="<br><br><br><table border=1><tr><th>Grade</th><th>Minimum Marks</th><th>Maximum Marks</th></tr>";
	for( let grades of data)
		{
		content +="<tr><td>"+grades.grade +"</td><td>"+grades.minMark+"</td><td>"+grades.maxMark+ "</td></tr>";
		}

       
       document.getElementById("viewdetails").innerHTML=content;
     });
    }

function viewTop(){
    event.preventDefault();
    var url ="http://localhost:8080/web/FrontController/viewtop.do";
    $.get(url, function(response){
        console.log(response);
        var data=JSON.parse(response);
      
        var content="<br><br><br><table border=1><tr><th>Registration number</th><th>Name</th></tr>";
 	for( let marks of data)
 		{
 		content +="<tr><td>"+marks.student.registrationNumber+"</td><td>"+marks.student.name+"</td></tr></table><br>";
 		break;
 		}

        var contents="<table border=1><tr><th>Subject Id</th><th>Subject Name</th><th>Marks</th></tr>";
     	for(let mark of data)
    		{
    		contents +="<tr><td>"+mark.subjects.id +"</td><td>"+mark.subjects.name+"</td><td>"+mark.marks+ "</td></tr>";
    		}
        
     	 document.getElementById("viewdetails").innerHTML=content+contents;
        
      });
     }
      
function viewallmarks(){
    var url ="http://localhost:8080/web/FrontController/viewallmarks.do";
    $.get(url, function(response){
        console.log(response);
        var data=JSON.parse(response);
		var checkRegNo;
		var checksubject;

	 var content="<br><br><br><table border=1><tr><th>Registration number</th><th>Name</th>";
for(let mark of data)
    		{
			if(checksubject!=mark.student.registrationNumber || checkRegNo!=mark.student.registrationNumber){
    		content +="</td><td>"+mark.subjects.name+"</td>";
    		}
			checksubject=mark.subjects.name;
			checkRegNo=mark.student.registrationNumber
			}
			content+="</tr>"

     	 document.getElementById("viewdetails").innerHTML=content;
        
      });
     }
     
   
function viewBySubject(){
 event.preventDefault();
      var subjectcode = document.getElementById("subjectdetail").value;
      var formData="subjectdetails=" +subjectcode.trim(); 
         console.log(formData);
     var url ="http://localhost:8080/web/FrontController/viewBySubject.do?"+formData;
    $.get(url, function(response){
        console.log(response);
        var data=JSON.parse(response);
        var content;
  	 content="<div class=container><br><br><br><form method='post' onsubmit='viewBySubject()'><div class='form-group'><input type='text' class='form-control' name='subjectdetail' id='subjectdetail' placeholder='subject code' required='required'></div><div class='form-group' align=center><button type='submit' class='btn btn-primary btn-xs'>Search</button>&nbsp<button type='reset' class='btn btn-primary btn-xs'>clear</button></div>"      
        if(data.length!=0)
       {
       for( let mark of data)
		{ 
       content+="<br><br>Subject Id="+mark.subjects.id+"&nbsp&nbsp&nbspSubject Name="+mark.subjects.name+"<br><br><table border=1><tr><th>Student ID</th><th>Student Name</th><th>Marks</th><th>Grade</th></tr>";
		break;}
	
	for( let mark of data)
		{
		content +="<tr><td>"+mark.student.id +"</td><td>"+mark.student.name+"</td><td>"+mark.marks+ "</td><td>"+mark.grade+"</td></tr>";
		}

       document.getElementById("viewdetails").innerHTML=content;
     }
     else
     {
      var url ="http://localhost:8080/web/FrontController/viewAvailableSubjects.do";
    $.get(url, function(response){
        console.log(response);
        var data=JSON.parse(response);
    	content+="<br><h3>subject not available.....<br></h3>select from available options...";
     	content+="<table border=1><tr><th>Subject ID</th><th>Subject Name</th></tr>";
     	for( let subject of data)
		{
		content +="<tr><td>"+subject.id +"</td><td>"+subject.name+"</td></tr>";
		}
     	content+="</table>";
     	
     	
      document.getElementById("viewdetails").innerHTML=content;
      });}
      
     });
     }
      
     function viewBySubjects(){
    event.preventDefault();
   var content="<div class=container><br><br><br><form method='post' onsubmit='viewBySubject()'><div class='form-group'><input type='text' class='form-control' name='subjectdetail' id='subjectdetail' placeholder='subject ID/Name' required='required'></div><div class='form-group' align=center><button type='submit' class='btn btn-primary btn-xs'>Search</button>&nbsp<button type='reset' class='btn btn-primary btn-xs'>clear</button></div>"
document.getElementById("viewdetails").innerHTML=content;   
  }