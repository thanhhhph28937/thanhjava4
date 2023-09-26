<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container mt-3">
    <table class="table">
        <thead>
        <tr>
            <th style="width: 10%">Id</th>
            <th style="width:10%">Title</th>
            <th style="width: 25%">Description</th>
            <th style="width: 10%">Active</th>
            <th style="width: 30%">Video</th>
            <th style="width: 15%">Action</th>
        </tr>
        </thead>
        <c:forEach items="${items}" var="vd">
            <tr>
                <td>${vd.id}</td>
                <td>${vd.title}</td>
                <td>${vd.description}</td>
                <td>
                    <c:if test="${vd.active}">Yes</c:if>
                    <c:if test="${!vd.active}">No</c:if>
                </td>
                <td>
                    <c:if test="${not empty vd.poster}">
                        <video width="320" height="180" controls>
                            <source src="/assignment_full_war_exploded/uploads/${vd.poster}" type="video/mp4">
                        </video>
                    </c:if>
                </td>
                <td>

                    <a class="btn btn-sm btn-secondary" href="edit?id=${vd.id}">Update</a>
                    <a class="btn btn-sm btn-danger"
                       href="delete?id=${vd.id}"
                       onclick="return confirm('Are you want to delete?')"
                    >Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${items.size() == 0}">
            <tr>
                <td colspan="6">No item found</td>
            </tr>
        </c:if>
    </table>
    <a href="new" class="btn btn-primary">New video</a>
</div>
