<html>
<#include "../common/header.ftlh">

<body>
<div class="col-md-12 column">
    <table class="table table-bordered table-condensed">
        <thead>
        <tr>
            <th>username</th>
            <th>email</th>
            <th>phone</th>
            <th>role</th>
            <th>create time</th>
            <th>update time</th>
        </tr>
        </thead>
        <tbody>

        <#list users as user>
            <tr>
                <td>${user.username!''}</td>
                <td>${user.email!''}</td>
                <td>${user.phone!''}</td>
                <td>
                    <#list user.roles as role>
                        ${role.name!''}
                    </#list>
                </td>
                <td>${user.createTime}</td>
                <td>${user.updateTime}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>