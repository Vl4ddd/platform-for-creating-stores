<!DOCTYPE html>
<html>
<head>
  <title>MarketPlace</title>
</head>
<body>
<h1>MarketPlace</h1><hr>
<form action="/" method="get">
  Поиск по названию объявления: <input type="text" name="title"><br>
  <input type="submit" value="Поиск"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
<#else>
<h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/addToBucket/${product.id}" method="post">
  Название: <input type="text" name="title"/><br><br>
  Описание: <input type="text" name="description"/><br><br>
  Цена: <input type="number" name="price"/><br><br>
  <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>