<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-3">
    <form action="search" method="post">
        <div class="row">
            <div class="col-9">
                <input class="form-control" placeholder="Enter keyword to search" name="keyword" value="${param.keyword}">
            </div>
            <div class="col-3">
                <button class="btn btn-primary" type="submit">Search</button>
            </div>
        </div>
    </form>

    <div class="navbar" >
        <a href="home">Home</a>
        <a href="#">About</a>
        <a href="#">Services</a>
        <a href="#">Portfolio</a>
        <a href="#">Contact</a>
    </div>
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
<style>
    /* Style the navbar */
    .navbar {
        overflow: hidden;
        background-color: white;
        margin-bottom: 10px;
    }

    /* Style the navigation bar links */
    .navbar a {
        float: left;
        display: block;
        color: blue;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    /* Change color on hover */
    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }

</style>
