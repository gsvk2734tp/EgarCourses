var $count = 6;

$('.delete1').click(function () {
    $(document.getElementById("delete1")).remove();
});

$('.delete2').click(function () {
    $(document.getElementById("delete2")).remove();
});

$('.delete3').click(function () {
    $(document.getElementById("delete3")).remove();
});

$('.delete4').click(function () {
    $(document.getElementById("delete4")).remove();
});

$('.delete5').click(function () {
    $(document.getElementById("delete5")).remove();
});

$('ol.list').on("click", ".delete", function(){
    var x = this.parentElement.className;
    console.log(x);
   $(this.parentNode).remove();
});

$('.btn.btn-primary').click(function () {

    var li = document.createElement('li');
    li.id = 'delete' + $count;

    var inp1 = document.createElement( 'input' );
    inp1.type = 'checkbox';
    inp1.id = 'checkbox' + $count;

    var lab1 = document.createElement( 'label' );
    lab1.append(document.getElementById('input-1').value);

    var lab2 = document.createElement( 'label' );
    lab2.id = "delete" + $count;
    lab2.className = "delete";
    lab2.append("Удалить");

    li.appendChild(inp1);
    li.appendChild(lab1);
    li.appendChild(lab2);

    $(document.getElementsByClassName("list")).append(li);

    document.getElementById('input-1').value = '';
    $count++;
});