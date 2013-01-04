int a = 1, b = 2.43e5;
if (a==1) {
  write a;
} else {
  write b;
}

if (5 == 2) {
  int b;
  read b;
}

int c = 0;
while (c <> 5) {
  c = c + 1;
}

c = 1 + 1;
// line comment
c = 5 / c;
c = c * 2;
/*
 * multi-line comment
 */
c = c - 1;// result to be 4
write c;

int d[5];
d[0] = 1;
write d[0];
int e;
read e;
write e;
