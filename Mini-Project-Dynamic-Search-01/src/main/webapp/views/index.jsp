<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
      
      <div class="container">
      <h3 class="primary">CITIZEN PLAN DETAILS</h3>
      <form:form action="search" modelAttribute="citizen" method="post">
      
        <table>
         <tr>
         <td>PlanName:</td>
         <td><form:select path="planName">
         
            <form:option value="">-select-</form:option>
            <form:options  items="${planName}"/>
         
         </form:select>        </td>
         
         
         </tr>
         <tr>
         <td>PlanStatus:</td>
         <td><form:select path="planStatus">
         
            <form:option value="">-select-</form:option>
            <form:options  items="${planStatus}"/>
         
         </form:select>        </td>
         </tr>
        
        <tr>
        
        <td>Gender:</td>
        
        <td><form:select path="gender">
        <form:option value="">-select-</form:option>
           <form:option value="male">Male</form:option>
            <form:option value="female">Fe-Male</form:option>
          </form:select></td>
        </tr>
        <tr>
        <td>Start Date:</td>
       <td> <form:input path="startDate" type="date"/></td>
       
       <td>End Date:</td>
       <td> <form:input path="endDate" type="date"/></td>
        
        </tr>
        
        
        
        </table>
      
      <input class="btn btn-primary" type="submit" value="search"> 
      
      </form:form>
      <hr>
      <table class="table table-striped,table table-hover" border="3">
      
      <thead>
      
      <tr class="table-danger">
      <td>
      CitizenName
      </td>
      <td>
      Gender
      </td>
      <td>
      PlanName
      </td>
      <td>
      PlanStatus
      </td>
      <td>
      StartDate
      </td>
      <td>
     EndDate
      </td>
       <td>
     BenifitAmount
      </td>
       <td>
     DenielReason
      </td>
      
      </tr>
      </thead>
      
      <tbody>
      
      <c:forEach items="${search}" var="p">
      
        <tr>
        
        <td>${p.citizenName}</td>
        <td>${p.gender}</td>
        <td>${p.planName}</td>
        <td>${p.planStatus}</td>
        <td>${p.palnStartDate}</td>
        <td>${p.planEndDate}</td>
        <td>${p.benifitAmount}</td>
        <td>${p.deniedReason}</td>
        </tr>
        
      </c:forEach>
      <tr>
      <c:if test="${empty search}">No Records Found</c:if></tr>
      
      
      </tbody>
      </table>
      Export:<a href="excel">Excel</a> 
             <a href="pdf">Pdf</a>
      </div>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>