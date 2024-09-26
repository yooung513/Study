console.log(A1);    // 변수의 호이스팅으로 인해 오류가 발생하지 않음
var A1 = "hello";
console.log(A1);
var A1 = "100";
console.log(A1);

let msg = "GLOBAL";
function outer() {
    let msg = "OUTER"
    console.log(msg);

    if (true) {
        let msg = "BLOCK";
        console.log;
    }
}
outer();