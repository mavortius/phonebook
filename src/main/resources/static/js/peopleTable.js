$(document).ready(function () {
    $('#employeesTable').DataTable();
});

function openPersonModal(id) {
    $.ajax({
        url: "/person/" + id,
        success: function (data) {
            $("#personModalHolder").html(data);
            $("#personModal").modal("show");
        }
    });
}

function okClick(id) {
    $.ajax({
        url: "/people/" + id,
        success: function (data) {
            console.log(id + " " + data);
        },
        error: function (data) {
            alert("Erro" + data);
        }
    });
}