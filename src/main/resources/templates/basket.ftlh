<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="_csrf_token" content="${_csrf.token}"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/css/style.css">
    <title>MyBasket</title>
</head>
<body>

<header class="header pb-2 container">
    <nav class="navbar navbar-expand-md navbar-light">
        <div class="container">
            <a class="navbar-brand me-5" href="/">
                <i class="bi bi-house-fill"></i>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navigation"
                    aria-controls="navigation" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse mt-3" id="navigation">
                <ul class="navbar-nav text-uppercase">
                    <li class="nav-item me-4">
                        <a class="nav-link" href="/customer/profile"><i class="bi bi-person-circle"></i></a>
                    </li>

                </ul>
                <hr class="text-white">
                <#if _csrf??>
                    <form action="/customer/save" method="post">
                        <input type="hidden"
                               name="${(_csrf.parameterName)!'csrf'}"
                               value="${(_csrf.token)!'--no-token--'}"
                        />

                        <button type="submit" id="logout" class="btn btn-danger ms-auto text-uppercase fw-bold" >
                            <i class="bi bi-box-arrow-right"></i>
                        </button>
                    </form>
                </#if>
            </div>
        </div>
    </nav>
</header>

    <div class="container mt-5 mb-5">
        <h2 class="section-title text-center"></h2>
        <div class="row" id="contents">
            <#list basket.itemsWA as itemWA>
                <div class="card" style="width: 18rem;">
                    <img src="/${itemWA.item.image}" class="card-img-top" alt="${itemWA.item.name}">
                    <div class="card-body">
                        <h5 class="card-title">${itemWA.item.name} : ${itemWA.number}pcs</h5>
                        <p class="card-text">${itemWA.item.description}</p>
                        <p class="card-text">${itemWA.item.price}$/pcs   Total:${itemWA.number * itemWA.item.price}$</p>
                    </div>
                    <div class="card-footer">
                        <form action="/user/basket/itemplus" method="post">
                            <#if _csrf??>
                                <input type="hidden"
                                       name="${(_csrf.parameterName)!'csrf-param-name'}"
                                       value="${(_csrf.token)!'csrf-token'}"/>
                            </#if>
                            <input type="hidden" name="itemId" value="${itemWA.item.id}">
                            <button class="btn btn-primary" type="submit">ADD</button>
                        </form>
                        <form action="/user/basket/delete/item" method="post">
                            <#if _csrf??>
                                <input type="hidden"
                                       name="${(_csrf.parameterName)!'csrf-param-name'}"
                                       value="${(_csrf.token)!'csrf-token'}"/>
                            </#if>
                            <input type="hidden" name="itemId" value="${itemWA.item.id}">
                            <button class="btn btn-primary" type="submit">DELETE</button>
                        </form>
                        <form action="/order" method="post">
                            <#if _csrf??>
                                <input type="hidden"
                                       name="${(_csrf.parameterName)!'csrf-param-name'}"
                                       value="${(_csrf.token)!'csrf-token'}"/>
                            </#if>
                            <input type="hidden" name="itemId" value="${itemWA.item.id}">
                            <button class="btn btn-primary" type="submit">Buy now</button>
                        </form>
                    </div>
                </div>
            </#list>

        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="script.js"></script>
</body>
</html>