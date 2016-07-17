angular.module("ListaPessoas", []);
angular.module("ListaPessoas").controller("ListaPessoasCtrl", function ($scope, $http) {

    $scope.pessoas = [];

    var carrgarPessoas = function () {
        $http.get("http://localhost:8080/SeletivoTechne/rest/pessoa/").success(function (data, status) {
            $scope.pessoas = data;
        });
    };

    $scope.adicionarPessoa = function (pessoa) {

        if (!pessoa.id) {

            $http({
                method: 'POST',
                url: "http://localhost:8080/SeletivoTechne/rest/pessoa/",
                data: pessoa
            }).then(function successCallBack(response) {
                carrgarPessoas();
                $scope.limparPessoa();
            }, function erroCallBack(response) {
                alert('Erro ao salvar a pessoa!');
            });
            
        } else {

            $http({
                method: 'PUT',
                url: "http://localhost:8080/SeletivoTechne/rest/pessoa/",
                data: pessoa
            }).then(function successCallBack(response) {
                carrgarPessoas();
                $scope.limparPessoa();
            }, function erroCallBack(response) {
                alert('Erro ao salvar a pessoa!');
            });
        }


    };

    $scope.apagarPessoa = function (pessoa) {
        $http({
            method: 'DELETE',
            url: "http://localhost:8080/SeletivoTechne/rest/pessoa/" + pessoa.id
        }).then(function successCallBack(response) {
            carrgarPessoas();
            $scope.limparPessoa();
        }, function erroCallBack(response) {
            alert('Erro ao excluir a pessoa!');
        });
    };

    $scope.editarPessoa = function (pessoa) {
        $http.get("http://localhost:8080/SeletivoTechne/rest/pessoa/" + pessoa.id).success(function (data, status) {
            $scope.pessoa = data;
        });
    };

    $scope.limparPessoa = function () {
        delete $scope.pessoa;
    };

    carrgarPessoas();
});