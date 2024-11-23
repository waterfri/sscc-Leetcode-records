// #13 罗马数字转整数
// 更高效的方法：从末位向前判断
int romanToInt(char* s) {
    int v = 0;
    int i = 0;
    for(i=0;i<strlen(s)-1;i++){
        if(s[i] == 'I'){
            if(s[i+1] == 'V'){
                v = v + 4;
                i++;
                continue;
            }
            if(s[i+1] == 'X'){
                v = v + 9;
                i++;
                continue;
            }
            else{
                v = v + 1;
                continue;
            }
        }
        if(s[i] == 'X'){
            if(s[i+1] == 'L'){
                v = v + 40;
                i++;
                continue;
            }
            if(s[i+1] == 'C'){
                v = v + 90;
                i++;
                continue;
            }
            else{
                v = v + 10;
                continue;
            }
        }
        if(s[i] == 'C'){
            if(s[i+1] == 'D'){
                v = v + 400;
                i++;
                continue;
            }
            if(s[i+1] == 'M'){
                v = v + 900;
                i++;
                continue;
            }
            else{
                v = v + 100;
                continue;
            }
        }
        if(s[i] == 'V'){
            v = v + 5;
            continue;
        }
        if(s[i] == 'L'){
            v = v + 50;
            continue;
        }
        if(s[i] == 'D'){
            v = v + 500;
            continue;
        }
        if(s[i] == 'M'){
            v = v + 1000;
            continue;
        }
    }
    if(s[i] == 'I'){
        v = v + 1;
    }
    if(s[i] == 'X'){
        v = v + 10;
    }
    if(s[i] == 'C'){
        v = v + 100;
    }
    if(s[i] == 'V'){
        v = v + 5;
    }
    if(s[i] == 'L'){
        v = v + 50;
    }
    if(s[i] == 'D'){
        v = v + 500;
    }
    if(s[i] == 'M'){
        v = v + 1000;
    }
    return v;
}