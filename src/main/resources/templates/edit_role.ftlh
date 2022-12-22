<head>
    <meta charset="UTF-8">
    <title>New MTUCI LMS</title>
    <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<h3>Редактировать роль</h3>
<form class="edit-form" action="/role/edit/${role.id}" method="post">
    <input type="number" name="id" value="${role.id}" hidden>

    <label>Имя</label>
    <input type="text" name="name" value="${role.name}">

    <label>Уровень доступа</label>
    <input type="text" name="permissionLevel" value="${role.permissionLevel}">

    <input type="submit" value="Confirm">

</form>
