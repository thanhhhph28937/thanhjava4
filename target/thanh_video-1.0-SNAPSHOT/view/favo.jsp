<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/5/2023
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-3">
    <form action="tim" method="post">
        <div class="row">
            <div class="col-9">
                <input class="form-control" placeholder="Enter keyword to search" name="keyword" value="${param.keyword}">
            </div>
            <div class="col-3">
                <button class="btn btn-primary" type="submit">Search</button>
            </div>
        </div>
    </form>

    <ul class="list-unstyled row">
        <c:forEach items="${list}" var="vd">
            <li class="col-4">
                <a href="detail?id=${vd.id}" class="text-decoration-none">
                    <div class="card">
                        <video class="card-img-top" src="uploads/${vd.poster}" controls>
                            <source src="uploads/${vd.poster}">
                        </video>
                        <div class="card-body">
                            <h5 class="card-title">${vd.title}</h5>
                        </div>
                    </div>
                </a>
            </li>
        </c:forEach>
    </ul>
    <c:if test="${items.size() == 0}">
        <div class="mt-2">No video found</div>
    </c:if>
</div>

