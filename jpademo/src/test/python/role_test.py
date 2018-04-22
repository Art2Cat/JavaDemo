import requests
import json


def hello_restful():
    r = requests.get("http://localhost:7477/")
    print(r.text)


def insert_role():
    url = 'http://localhost:7477/role/insertRole'
    role = {'roleName': 'testRole', 'createDate': '2018-4-22',
            'note': 'this is test role'}
    headers = {'content-type': 'application/json'}
    r = requests.post(url, data=json.dumps(role), headers=headers)
    print(r.headers)
    print(r.text)


def get_role():
    response = requests.get('http://localhost:7477/role/getRole?id=1')
    print(response.text)


def update_role():
    url = "http://localhost:7477/role/updateRole"
    role = {'id': 1003, 'roleName': 'Vender', 'createDate': '2018-4-22', 'note': 'this is test role'}
    headers = {'content-type': 'application/json'}
    r = requests.put(url=url, data=json.dumps(role), headers=headers)
    print(r.headers)
    print(r.text)


def delete_role():
    url = 'http://localhost:7477/role/deleteRole?id=2'
    response = requests.delete(url)
    print(response.text)


def main():
    hello_restful()
    insert_role()
    get_role()
    update_role()
    delete_role()


if __name__ == '__main__':
    main()
