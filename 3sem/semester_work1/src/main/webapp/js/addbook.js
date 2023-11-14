function addBook(event) {
    event.preventDefault(); // страница не перезагружается после отправки формы

    // получаем значения полей формы
    var title = document.getElementById("title").value;
    var author = document.getElementById("author").value;
    var age = document.getElementById("age").value;
    var description = document.getElementById("description").value;

    // создаем новый элемент книги
    var bookItem = document.createElement("div");
    bookItem.className = "book-item";
    bookItem.innerHTML = "<h2>Title: " + title + "</h2>" +
        "<p>Author: " + author + "</p>" +
        "<p>Age: " + age + "</p>" +
        "<p>Description: " + description + "</p>";

    // добавляем новую книгу в блок "bookList"
    var bookList = document.getElementById("bookList");
    bookList.appendChild(bookItem);

    // сбрасываем значения полей формы
    document.getElementById("title").value = "";
    document.getElementById("author").value = "";
    document.getElementById("age").value = "";
    document.getElementById("description").value = "";

    return false;
}