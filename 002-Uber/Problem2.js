function productExceptSelf(arr){
    let size = arr.length;
    let result = new Array(size);
    let left = new Array(size);
    let right = new Array(size);

    left[0] = 1;
    right[size-1] = 1;

    //calculate left product
    for(let i=1;i<size;i++){
        left[i] = arr[i-1] * left[i-1];
    }

    //calucalte right product
    for(let i=size-2;i>=0;i--){
        right[i] = arr[i+1] * right[i+1];
    }

    for(let i=0;i<size;i++){
        result[i] = left[i] * right[i];
    }
}


