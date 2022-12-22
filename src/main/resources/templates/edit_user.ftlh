<head>
    <meta charset="UTF-8">
    <title>New MTUCI LMS</title>
    <link rel="stylesheet" type="text/css" href="/style.css"/>
</head>
<h3>Редактировать пользователя</h3>
<form class="edit-form" action="/edit/${user.id}" method="post">
    <input type="number" name="id" value="${user.id}" hidden>
    <label>E-mail</label>
    <input type="text" name="email" value="${user.email}">
    <label>Роль</label>
    <select name="role_id">
        <#if (roleSize > 0)>
            <#list roleList as rl>
                <option value="${rl.id}" <#if (user.role??)><#if (user.role.id == rl.id)>selected</#if></#if>>${rl.name}</option>
            </#list>
        </#if>
    </select>
    <label>Пол</label>
    <input type="checkbox" name="gender" <#if (user.gender == true)>checked</#if>>
    <input type="submit" value="Confirm">
</form>
