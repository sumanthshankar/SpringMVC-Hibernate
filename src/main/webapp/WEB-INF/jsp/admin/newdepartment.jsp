<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
  <title>New Department</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style type="text/css">
 .panel-primary {
    border-color: #948D8C;
}
  .panel-primary>.panel-heading {
    color: #fff;
    background-color: #948D8C;
    border-color: #F9F9F9;
}
  </style>
</head>
<body>
<div class="container">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="admin.html">Graduate Application Program</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="admin.html">Home</a></li>
      <li><a href="../logout.html">Logout</a></li>
    </ul>
   
  </div>
</nav> 
    <div class="panel panel-default">
      <div class="panel-heading">
		<ul class="breadcrumb">
		  <li><a href="admin.html">Home</a> <span class="divider"></span></li>
		  <li class="active">New Department</li>
		 </ul>
	  </div>
      <div class="panel-body">
       <div class="panel-body">
      	<div class="panel panel-primary">
     		<div class="panel-heading">Department</div>
      		<div class="panel-body">
      			<form role="form"  class="form-horizontal" action = "newdepartment.html" method = "post">
			      	<div class="form-group">
					    <label for="text"  class="control-label col-sm-2">Department Name:</label>
					    <div class="col-sm-3">
						    <c:choose>
							    <c:when test="${departmentID != '' and departmentID != null }">
							    	<c:out value="${departmentName }"></c:out>
							    </c:when>
							    <c:otherwise>
							        <input type="text" class="form-control" id="name" name = "departmentName" required>
							    </c:otherwise>
							</c:choose>
					  	  	
					  	 </div>
					  </div>
					  <c:if test="${departmentID == '' or departmentID == null }">
						  <div class="form-group">        
				     		<div class="col-sm-offset-2 col-sm-10">
				     		
								<button type="submit" class="btn btn-danger" name = "function" value = "department">Add Department</button>
						  </div>
						 </div>
					  </c:if>
				
				</form>
      		</div>
   		</div>
      	<div class="panel panel-primary">
	      <div class="panel-heading">Programs</div>
	      <div class="panel-body">
	      <c:forEach items="${programs}" var="program">
	      	<c:out value="${program.programName }" ></c:out>,
	      </c:forEach>	      
	      	<form role="form"  class="form-horizontal" action = "newdepartment.html" method = "post">
	      			<c:if test="${departmentID != '' and departmentID != null }">
	      				<input type = "hidden" name = "departmentID" value ="${departmentID }"/>
	      			</c:if>
			      	<div class="form-group">
					    <label for="text"  class="control-label col-sm-2">Program Name:</label>
					    <div class="col-sm-3">
					  	  <input type="text" class="form-control" id="name" name = "programName" required>
					  	 </div>
					  </div>
					  <div class="form-group">        
			     		<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-danger" name = "function" value = "program" 
							<c:if test="${departmentID == '' or departmentID == null}" ><c:out value = "disabled='disabled'"></c:out></c:if>
							>Add Program</button>
					  </div>
				</div>
				</form>
	      </div>
	    </div>
      	<div class="panel panel-primary">
	      <div class="panel-heading">Additional Fields</div>
	      <div class="panel-body">
	      <c:if test="${fn:length(additionalFields) gt 0}">
		      <table class="table table-hover">
			    <thead>
			      <tr>
			        <th>Field Name</th>
			        <th>Type</th>
			        <th>Required/Optional</th>
			      </tr>
			    </thead>
    			<tbody>
    			<c:forEach items="${additionalFields}" var="fields">
    					<tr>
    						<td>${fields.nameOfField }</td><td>${fields.fieldType}</td><td>${fields.requiredOrOptional}</td>
    					</tr>
    			</c:forEach>
    			
    			</tbody>
    		</table>
	      </c:if>
	      
	      	<form role="form"  class="form-inline" action = "newdepartment.html" method = "post">
	      		<c:if test="${departmentID != '' and departmentID != null }">
	      				<input type = "hidden" name = "departmentID" value ="${departmentID }"/>
	      		</c:if>
			      	<div class="form-group">
					    <label for="text"  class="control-label col-sm-2">Field Name:</label>
					    <div class="col-sm-3">
					  	  <input type="text" class="form-control" id="fieldname" name = "fieldname" required>
					  	 </div>
					  </div>
					  <div class="form-group">
						  <label for="sel1">Field Type</label>
						  <select class="form-control" id="fieldtype" name = "fieldtype">
						    <option value = "text">TEXT</option>
						    <option value = "file">FILE</option>
						    <option value ="number">NUMBER</option>
						  </select>
					  </div>
					  <label class="radio-inline"><input type="radio" value = "required" name="required" checked>Required</label>
					  <label class="radio-inline"><input type="radio" value = "optional" name="required">Optional</label>
					
					  <div class="form-group">        
			     		<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-danger"  name="function" value = "additionalField"
							<c:if test="${departmentID == '' or departmentID == null}" ><c:out value = "disabled='disabled'"></c:out></c:if>
							>Add Field</button>
					  </div>
				</div>
				</form>
	      </div>
	    </div>
	    <a href = "listdepartment.html"><button type="button" class="btn btn-danger"  name="function" value = "done">All Done !</button></a>
      </div>
    </div>
</div>
</div>
<footer class="footer">
      <div class="container">
        <p class="text-muted">California State University, Los Angeles. Graduate application program</p>
      </div>
</footer>
</body>
</html>
