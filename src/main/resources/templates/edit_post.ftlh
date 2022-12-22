<head>
    <meta charset="UTF-8">
    <title>New MTUCI LMS</title>
    <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<h3>Редактировать пост</h3>
<form class="edit-form" action="/post/edit/${post.id}" method="post">
    <input type="number" name="id" value="${post.id}" hidden>
    <input type="number" name="user_id" value="${post.user.id}" hidden>
    <label>Пользователь</label>
    <input type="text" value="${post.user.email}" disabled>
    <label>Заголовок</label>
    <input type="text" name="title" value="${post.title}">
    <label>Описание</label>
    <input type="text" name="description" value="${post.description}">
    <input type="submit" value="Confirm">
</form>
