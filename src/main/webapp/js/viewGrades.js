
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
    event.preventDefault();
    var url ="http://localhost:8080/web/FrontController/viewallmarks.do";
    $.get(url, function(response){
        console.log(response);
        var data=JSON.parse(response);
		var checkRegNo;
		var checksubject;

	 var content="<br><br><br><table border=1><tr><th>Registration number</th><th>Name</th>";
for(let mark of data)
    		{
			if(checksubject!=mark.student.registrationNumber && checkRegNo!=mark.student.registrationNumber){
    		content +="</td><td>"+mark.subjects.name+"</td>";
    		}
			checksubject=mark.subjects.name;
			checkRegNo=mark.student.registrationNumber
			}
			content+="</tr>"

     	 document.getElementById("viewdetails").innerHTML=content;
        
      });
     }
      
