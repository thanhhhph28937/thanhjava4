<%@ include file="theme/navbar.jsp"%>

<div class="container mt-3">
    <div class="d-flex">

        <h3 style="flex:1">${video.title}</h3>
        <div>
            <c:if test="${not empty item}">
            <button class="btn btn-sm border-primary">Like</button>
            </c:if>

           <c:if test="${empty item}">
            <button class="btn btn-sm border-primary">Unlike</button>
           </c:if>
        </div>

    </div>

    <video  width="100%" controls>
        <source src="/assignment_full_war_exploded/uploads/${video.poster}">
    </video>

</div>