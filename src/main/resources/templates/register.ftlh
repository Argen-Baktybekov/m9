<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="_csrf_token" content="${_csrf.token}"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
    <title>NEW</title>
</head>
<body>
<div class="container container-fluid">
    <form action="./newCustomer" method="post" class="register-form" id="register_form">
        <#if _csrf??>
            <input type="hidden"
                   name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>
        <div>
            <input name="firstName" type="text" placeholder="Name" required>
        </div>
        <div>
            <input name="lastName" type="text" placeholder="Last name">
        </div>
        <div>
            <input name="email" type="email" placeholder="Email" required>
        </div>
        <div>
            <input name="password" type="password" placeholder="Password" required>
        </div>
        <div>
            <input name="phone" type="tel" placeholder="Phone" required>
        </div>
        <div>
            <input name="cardNumber" type="text" placeholder="Card Number" required>
        </div>
        <div class="form-footer">
            <button type="submit" class="btn btn-primary">Send</button>
            <button type="reset" class="btn btn-primary">Reset</button>
        </div>
    </form>
</div>
</body>
</html>