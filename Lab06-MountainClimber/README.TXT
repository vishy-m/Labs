//         while (col != cols - 1)
        //         {
        //             int up = Math.abs(space - grid[row - 1][col]);
        //             int right = Math.abs(space - grid[row][col]);
        //             int down = Math.abs(space - grid[row + 1][col]);
        //             int[] spaces = {up, right, down};
        //             for (int i = 0; i < 2; i++)
        //             {
        //                 if (spaces[i] < spaces[i + 1])
        //                     row = oldRow + (i - 1);
        //                 if (spaces[i] == spaces[i + 1])
        //                     row = oldRow + (i);
        //             }
        //             if (spaces[0] == spaces[1] || spaces[i] == spaces[2] || spaces[1])
        //                 row = oldRow + 1;
        //             if (spaces[0] == spaces[2])
        //                 row = oldRow + 1;
        //             StdDraw.filledRectangle(col, grid.length - 1 - row, 0.5, 0.5);
        //             oldRow = row;
        //             col++;
        //             space = grid[row][col - 1];
        //         }