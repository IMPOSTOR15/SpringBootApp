<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SPRING APPLICATION LOL</title>
    <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<body>
<#--ROLES-->
<div class="table_container">
    <form class="form-wrapper" id="add_role" action="/role/add" method="post">
        <h2>Создать роль</h2>
        <label>Название роли</label>
        <input class="name-input" type="text" name="name">
        <label>Уровень доступа</label>
        <input class="number-input" type="number" value="0" name="permissionLevel">
        <a class="add-button" href="javascript:{}" onclick="document.getElementById('add_role').submit();">Добавить</a>
    </form>
    <div class="table-wrapper">
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Роль</td>
                <td>Уровень достпа</td>
            </tr>
            <#list roleList as role>
                <tr>
                    <td>${role.id}</td>
                    <td>${role.name}</td>
                    <td>${role.permissionLevel}</td>
                    <td><a href="${'/role/edit/'+role.id}">Редактировать</a></td>
                    <td><a href="${'/role/delete/'+role.id}">Удалить</a></td>
                </tr>
            </#list>
        </table>
    </div>
</div>
<#--USERS-->
<div class="table_container">
    <form class="form-wrapper" id="add_user" action="/add" method="post">
        <h2>Создать</h2>
        <h2>пользователя</h2>
        <label>Е-mail Пользователя</label>
        <input type="text" name="email">
        <label>Роль</label>
        <select name="role_id">
            <#if (roleSize > 0)>
                <#list roleList as rl>
                    <option value="${rl.id}">${rl.name}</option>
                </#list>
            </#if>
        </select>
        <label>Пол</label>
        <input type="checkbox" name="gender">
        <a class="add-button" href="javascript:{}" onclick="document.getElementById('add_user').submit();">Add</a>
    </form>
    <div class="table-wrapper">
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>E-mail</td>
                <td>Роль</td>
                <td>Пол</td>
            </tr>
            <#list userList as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td><#if user.role??>${user.role.name}</#if></td>
                    <td>${user.gender?string("Мужской", "Женский")}</td>
                    <td><a href="${'/edit/'+user.id}">Редактировать</a></td>
                    <td><a href="${'/delete/'+user.id}">Удалить</a></td>
                </tr>
            </#list>
        </table>
    </div>
</div>
<#--POSTS-->
<div class="table_container">
    <form class="form-wrapper" id="add_post" action="/post/add" method="post">
        <h2>Создать пост</h2>
        <label>Имя пользователя</label>
        <select name="user_id">
            <#if (userSize > 0)>
                <#list userList as ul>
                    <option value="${ul.id}">${ul.email}</option>
                </#list>
            </#if>
        </select>
        <label>Заголовок</label>
        <input type="text" name="title">
        <label>Описание</label>
        <input type="text" name="description">
        <a class="add-button" href="javascript:{}" onclick="document.getElementById('add_post').submit();">Add</a>
    </form>
    <div class="table-wrapper">
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Пользователь</td>
                <td>Заголовок</td>
                <td>Описание</td>
            </tr>
            <#list postList as post>
                <tr class="table-row">
                    <td>${post.id}</td>
                    <td>${post.user.email}</td>
                    <td>${post.title}</td>
                    <td>${post.description}</td>
                    <td><a href="${'/post/edit/'+post.id}">Редактировать</a></td>
                    <td><a href="${'/post/delete/'+post.id}">Удалить</a></td>
                </tr>
            </#list>
        </table>
    </div>
</div>
</body>
</html>
