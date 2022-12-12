// Write a function that can take in any number of arguments, and returns the sum of all of the arguments.
function sumOfNums(...nums){
    let sum = 0;
    for(let i = 0; i<nums.length;i++){
        sum += nums[i];
    }
    return sum;
}
console.log(sumOfNums(1,2,3,4,5));

// Write a function called addOnlyNums that can take in any number of arguments (including numbers or strings), and returns the sum of only the numbers.
function addOnlyNums(...nums){
    let sum = 0;
    for(let i = 0; i<nums.length;i++){
        if(typeof nums[i] === 'number' && isFinite(nums[i])){
            sum += nums[i];
        }
    }
    return sum;
}
console.log(addOnlyNums(1, 'cat', 3, 4));

// Write a function called `countTheArgs` that can take any number of arguments, and returns the number of arguments that are passed in.
function countTheArgs(...args){
    return args.length;
}
console.log(countTheArgs('cat', 'dog'));
console.log(countTheArgs('cat', 'dog', 'frog', 'bear'));

// Write a function called combineTwoArrays that takes in two arrays as arguments, and returns a single array that combines both (using the spread operator).
function combineTwoArrays(arr1,arr2){
    return [...arr1, ...arr2];
}
console.log(combineTwoArrays([1,2,3],[4,5,6]));


// Write a function called sumEveryOther that takes in any amount of arguments, and returns the sum of every other argument.
function sumEveryOther(...args){
    let sum = args[0];
    for(let i =1 ; i<=args.length; i++){
        if(i%2==0){
            sum+= args[i];
        }
    }
    return sum;
}
console.log(sumEveryOther(5, 6, 3, 4, 1)); //9
console.log(sumEveryOther(10, 2, 11)); //21

// Write a function called onlyUniques that can take in any number of arguments, and returns an array of only the unique arguments.
function onlyUniques(...args){
    let arr =[];
    for(let i = 0;i<args.length; i++){
        if(arr.includes(args[i])){

        }else{
            arr.push(args[i]);
        }
    }
    return arr;
}
console.log(onlyUniques('cat', 'cat', 'dog', 'pig'));
console.log(onlyUniques(1, 4, 7, 1, 2, 7, 4));

// Write a function called combineAllArrays that takes in any number of arrays as arguments and combines all of them into one array.
function combineAllArrays(...AllArrs){
    let newArr = [];
    for(let i = 0 ; i<AllArrs.length; i++){
        for(let j = 0; j<AllArrs[i].length;j++)
            newArr.push(AllArrs[i][j]);
    }
    return newArr;
}
console.log(combineAllArrays([1,2,3],[4,5,6],[7,8,9]));

// Write a function called squareAndSum that takes in any number of arguments, squares them, then sums all of the squares.
function squareAndSum(...args){
    let squared = [];
    for (let i = 0; i< args.length; i++){
        squared.push(args[i] * args[i]);
    }
    let sum = 0;
    for(let i = 0; i<squared.length; i++){
        sum += squared[i];
    }
    return sum;
}
console.log(squareAndSum(2, 4, 3));
console.log(squareAndSum(1, 2));