int a = 1, b = 2.43e5;
if (a<>1) {
  write a;
} else {
  write b;
}
write a+5;

if (1 == a) {
  int b;
  read b;
  write b;
}

int c = 0;
while (c <> 5) {
  c = c + 1;
}

c = 1 + 1;
// line comment
c = 5 / c;
c = c * 2;
c = c - 1;// result to be 4
write c;

int d[5];
d[0] = 1;
write d[0];
