<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container mt-3 mb-3">
    <form method="post" action="create" enctype="multipart/form-data">
        <div>
            <label for="id">ID:</label>
            <input class="form-control" id="id" name="id" value="${video.id}" required>
        </div>
        <div>
            <label for="title">Title:</label>
            <input class="form-control" id="title" name="title" value="${video.title}" required>
        </div>
        <div class="mt-3">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description" required
                >${video.description}</textarea>
        </div>
        <div class="mt-3">
            <label for="active">Active:</label>
            <input class="form-check-input" type="checkbox" name="active" id="active" required
                ${video.active?"checked": ""}>
        </div>
        <div class="mt-3">
            <label for="poster_file">Video:</label>
            <input class="form-control" type="file" id="poster_file" name="poster_file" required>
        </div>
        <div class="mt-2" style="color: red">${message}</div>
        <button class="mt-3 btn btn-primary">Save</button>
    </form>
</div>