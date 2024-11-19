<!DOCTYPE html>
<html>
<head>
    <title>MarketPlace</title>
</head>
<body>
<h1>MarketPlace</h1><hr>
<h4>Подробная информация о товаре</h4>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<hr>
<form action="/product/create" method="post">
  Имя: <input type="text" name="title"/><br><br>
  <input type="submit" value="Добавить в корзину"/>
</form>
</body>
</html>