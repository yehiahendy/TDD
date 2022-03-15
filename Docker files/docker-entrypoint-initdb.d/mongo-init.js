var isAuth = db.auth("root","1234");

if(isAuth)
{
    var arrayOfStudents = [{
        "id": 0,
        "name": "Yehia",
        "degree":100
      }, {
        "id": 1,
        "name": "Ahmed",
        "degree":90
      }, {
        "id": 2,
        "name": "Mohamed",
        "degree":80
      },{
        "id": 3,
        "name": "Youssef",
        "degree":98
      }];
    print("User is authenticated");
    db = db.getSiblingDB('TDD');
    db.createUser(
    {
    user: 'user',
    pwd: '1234',
    roles: [{ role: 'readWrite', db: 'TDD' }],
    },);
db.createCollection('users');
for(var i = 0 ; i < arrayOfStudents.length;i++)
    db.users.insert(arrayOfStudents[i]);
}
else
{
    print("User is not auth");
}
