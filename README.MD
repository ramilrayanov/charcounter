Write an application char-counter that takes a string and returns the number of unique characters in the string.

It is expected that a string with the same character sequence may be passed several times to the method.

Since the counting operation can be time-consuming, the method should cache the results, so that when the method is given a string previously encountered,

it will simply retrieve the stored result. Use collections and maps where appropriate.

E.g.

hello world!

"h" - 1
"e" - 1
"l" - 3
"o" - 2
" " - 1
"w" - 1
"r" - 1
"d" - 1
"!" - 1