<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="_csrf_token" content="${_csrf.token}"/>

    <#import "/spring.ftl" as spring>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">

    <title>m9</title>
</head>
<body>
<#--<@spring.message code="title"/>-->
<header class="header pb-2">
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
                        <a class="nav-link active" aria-current="page" href="#"><@spring.message "category"/></a>
                    </li>
                    <li>
                        <div class="form-outline input-group">
                            <input id="search-input" type="search" class="form-control"
                                   required placeholder="Item Name or Description"/>
                            <button id="search-button" type="button" class="btn btn-outline-secondary">
                                <i class="bi bi-search"></i>
                            </button>
                        </div>
                    </li>
                    <li class="nav-item me-4">
                        <a class="nav-link" href="/user/basket"><@spring.message "myBasket"/></a>
                    </li>
                    <li class="nav-item me-4">
                        <a class="nav-link" href="/customer/newCustomer"><@spring.message "register"/></a>
                    </li>
                    <li class="nav-item me-4">
                        <a class="nav-link" href="/customer/profile"><i class="bi bi-person-circle"></i></a>
                    </li>

                    <li class="nav-item me-4">

                            <span type="button" class="nav-link" data-bs-toggle="modal" data-bs-target="#newpost">
                                New Item
                            </span>
                    </li>
                    </li>
                </ul>
                <hr class="text-white">
                <#if _csrf??>
                    <form action="/customer/save" method="post">
                        <input type="hidden"
                               name="${(_csrf.parameterName)!'csrf'}"
                               value="${(_csrf.token)!'--no-token--'}"
                        />
                        <button type="submit" id="logout" class="btn btn-danger ms-auto text-uppercase fw-bold">
                            <i class="bi bi-box-arrow-right"></i>
                        </button>
                    </form>
                </#if>
                <form action="" method="get">
                    <label for="lang-select">
                        <@spring.message "label.language" />
                    </label>
                    <select name="lang" id="lang-select">
                        <option value="">Default</option>
                        <option value="en_EN">English</option>
                        <option value="ru_RU">Руский</option>
                    </select>
                    <button type="submit">
                        <@spring.message "button.language-change.text"/>
                    </button>
                </form>
            </div>
        </div>
    </nav>
</header>

<div class="container mt-5 mb-5 ">
    <div class="container mt-5 mb-5">
        <h2 class="section-title text-center"></h2>
        <div class="row" id="contents">
            <!--CONTENT-->
            <#list items as item>
                <div class="card" style="width: 18rem;">
                    <img src="${item.image}" class="card-img-top" alt="${item.name}">
                    <div class="card-body">
                        <h5 class="card-title"><@spring.message "name"/> : ${item.name}</h5>
                        <p class="card-text"><@spring.message "description"/> : ${item.description}</p>
                    </div>
                    <div class="card-footer">
                        <form action="/user/basket/item" method="post">
                            <#if _csrf??>
                                <input type="hidden"
                                       name="${(_csrf.parameterName)!'csrf-param-name'}"
                                       value="${(_csrf.token)!'csrf-token'}"/>
                            </#if>
                            <input type="hidden" name="itemId" value="${item.id}">
                            <button class="btn btn-danger" type="submit"><i class="bi bi-cart4 "></i></button>
                        </form>
                        <form action="/item/review" class="get-comment">
                            <input type="hidden" name="itemId" value="${item.id}">
                            <button class="comments btn btn-primary" type="button">
                            <span id="${item.id}" type="button" data-bs-toggle="modal" data-bs-target="#comments">
                                <@spring.message "review"/>
                            </span>
                            </button>
                        </form>
                    </div>
                </div>
            </#list>
        </div>
        <button type="button" id="prev" class="btn btn-primary">
            prev
        </button>
        <button type="button" id="next" class="btn btn-primary">
            next
        </button>
    </div>
</div>

<div class="modal fade" id="comments" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-success">
                <h5 class="modal-title" id="modal-title">Reviews:</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <div class="modal-body" id="modal">

            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="scripts/script.js"></script>

</body>
</html>