# Morning Routine

This is a toy CLI application that I wrote to learn Scala.  It simulates your morning routine, from getting dressed to leaving home.  You are currently wearing your PJ's.

## Usage

Run the application as shown:

```
./run.sh <temperature> <command code 1, command code 2, ...>
```

`temperature` should be one of: *HOT* or *COLD*

`command codes` should be integers *1-8* delimited by commas and/or spaces

| Code | Description |
| - | - |
| 1 | Footwear |
| 2 | Headwear |
| 3 | Socks |
| 4 | Shirt |
| 5 | Jacket |
| 6 | Pants |
| 7 | Leave home |
| 8 | Remove PJ's |

If a command is invalid, whether because it is undefined, a duplicate, or its prerequisites have not been met, the program will print `fail`, and immediately stop.

### Examples

```
./run.sh HOT 8, 1, 2
```

Successful run in hot weather

```
./run.sh HOT 8, 6, 4, 2, 1, 7
```

Successful run in cold weather

```
./run.sh COLD 8, 6, 3, 4, 2, 5, 1, 7
```

Commas and capitalization are optional.

```
./run.sh cold 8 6 3 4 2 5 1 7
```

Failure due to prerequisites

```
./run.sh HOT 8, 1, 2, 3
```

Failure due to duplicate commands

```
./run.sh HOT 8, 1, 2, 2
```

## Testing

You can run the included tests with the following command.  For your viewing pleasure, an HTML report will be generated, and its path will be shown in the output.

```
./test.sh
```