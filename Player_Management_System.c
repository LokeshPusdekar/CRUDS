
// Player Management System

#include<stdio.h>
#include<string.h>

typedef struct player
{
    char player_name[20];
    int jersey_num;
    int match_played;
    int runs;
    int wicket;
}player;

int store(player* p, int count, int size)
{       
    for (int i = 0; i < size; i++)
    {
        printf("Enter the details of player repectively:\n");

        printf("(1) Player Name   : \n");
        scanf("%s",p[count].player_name);

        printf("(1) Jersey Number : \n");
        scanf("%d",&p[count].jersey_num);

        printf("(1) Match played  : \n");
        scanf("%d",&p[count].match_played);

        printf("(1) Runs Scored   : \n");
        scanf("%d",&p[count].runs);

        printf("(1) Wicket.       : \n");
        scanf("%d",&p[count].wicket);
    
        count++;
    }

    printf("%d Player details is added to the Database.\n",count);
    
    // printf("\n");

    return count;
}

void display(player* p, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("Details of Player_%d\n",i);

        printf("Name of Player_                  :%s\n",p[i].player_name);
        printf("Jersey no. of Player_            :%d\n",p[i].jersey_num);
        printf("Matched Played by Player_        :%d\n",p[i].match_played);
        printf("Runs Scored by Player_           :%d\n",p[i].runs);
        printf("Number of wicket taken by Player_:%d\n",p[i].wicket);

        printf("\n");
    }
    // printf("\n");
}

void search(player* p, int size)
{   
    int choice, p_found=0;
    int j_num;
    char name[20]; 

    printf("Search Player by: \n");
    printf("(1)Jersey Number\n");
    printf("(2)Name\n");
    scanf("%d",&choice);

    if (choice == 1)
    {
        printf("Enter Jersey Number of Player:\n");
        scanf("%d",&j_num);

        for (int i = 0; i < size; i++)
        {
            if (p[i].jersey_num == j_num)
            {   
                printf(">>player_%d:\n",i+1);

                printf("Name of Player_                  :%s\n",p[i].player_name);
                printf("Jersey no. of Player_            :%d\n",p[i].jersey_num);
                printf("Matched Played by Player_        :%d\n",p[i].match_played);
                printf("Runs Scored by Player_           :%d\n",p[i].runs);
                printf("Number of wicket taken by Player_:%d\n",p[i].wicket);
                printf("\n");
                p_found = 1;
                break;
            } 
        } 

        if (p_found == 1)
        {
            printf("Done : Player with Jersey Number %d is Found !!!\n", j_num);
        }
        else
        {
            printf("ERROR : Player with Jersey Number %d is not Found !!!\n",j_num);
        }       
    }

    else if (choice == 2)
    {
        printf("Enter the Name of the Player: ");
        scanf("%s",name);
        printf("\n");

        for (int i = 0; i < size; i++)
        {
            if (strcmp(p[i].player_name, name) == 0)
            {   
                printf(">>player_%d:\n",i+1);

                printf("Name of Player_                  :%s\n",p[i].player_name);
                printf("Jersey no. of Player_            :%d\n",p[i].jersey_num);
                printf("Matched Played by Player_        :%d\n",p[i].match_played);
                printf("Runs Scored by Player_           :%d\n",p[i].runs);
                printf("Number of wicket taken by Player_:%d\n",p[i].wicket);
                printf("\n"); 
                p_found = 1;
                break;      
            }
        }

        if (p_found == 1)
        {
            printf("Done : Player of Name: %s is Found !!!\n", name);
        }
        else
        {
            printf("ERROR : Player of Name: %s is not Found !!!\n",name);
        }          
    }
    else
    {
        printf("Invalid search option.\n");
    }
    
}

void delete(player* p, int *size)
{
    int choice, p_delete=0, count = -1;
    int j_num,index1,index2;
    char name[20];

    printf("Search Player by: \n");
    printf("(1)Jersey Number\n");
    printf("(2)Name\n");
    scanf("%d",&choice);

    if (choice == 1)
    {
        printf("Enter the Jersey Number of the player:");
        scanf("%d",&j_num);

        for (int i = 0; i < *size; i++)
        {
            if (p[i].jersey_num == j_num)
            {
                count = i;
                break;
            }   
        }
        if (count == -1)
        {
            printf("Player not found.\n");
            return;
        }

        for (int i = count; i < *size - 1; i++)
        {
            p[i].jersey_num = p[i+1].jersey_num;  
            strcpy(p[i].player_name, p[i+1].player_name); 
            p[i].match_played = p[i+1].match_played; 
            p[i].runs = p[i+1].runs; 
            p[i].wicket = p[i+1].wicket; 
            index1 = i;
            p_delete = 1;
        }   
           
        for (int i = count; i < *size - 1; i++)
        {
            p[i] = p[i + 1];
        }
        (*size)--;

        if (p_delete == 1)
        {
            printf("Done : Player with Jersey Number: %d is deleted from the Database.\n", j_num); 
        }  
        else
        {
            printf("ERROR : player with Jersey Number: %d is not Found.\n",j_num);
        }     
    }
    else if (choice == 2)
    {
        printf("Enter the Name of the Player:");
        scanf("%s",name);

        for (int i = 0; i < *size; i++)
        {
            if (strcmp(p[i].player_name, name)  == 0)
            {
                count = i;
                break;
            }   
        }    

        for (int i = count; i < *size - 1; i++)
        {
            p[i].jersey_num = p[i+1].jersey_num;  
            strcpy(p[i].player_name, p[i+1].player_name); 
            p[i].match_played = p[i+1].match_played; 
            p[i].runs = p[i+1].runs; 
            p[i].wicket = p[i+1].wicket; 
            index2 = i;
            p_delete = 1;
        }

        for (int i = count; i < *size - 1; i++)
        {
            p[i] = p[i + 1];
        }
        (*size)--;
        
        if (p_delete == 1)
        {
            printf("Done : Player of Name: %s is deleted from the Database\n", name); 
        }  
        else
        {
            printf("ERROR : Player of Name: %s is not deleted from the Database\n",name);
        }
        
    }
    else
    {
        printf("Invalid search option.\n");
    }    
}

void update(player* p, int size)
{       
    int choice,count = -1;
    int j_num,up_choice,p_update = 0;
    char name[20],upd_name[20];

    printf("To Update search Player by: \n");
    printf("(1)Jersey Number\n");
    printf("(2)Name\n");
    scanf("%d",&choice);

    if (choice == 1)
    {       
        printf("Enter the Jersey Number of the Player:");
        scanf("%d",&j_num);

        for (int i = 0; i < size; i++)
        {
            if (p[i].jersey_num == j_num)
            {
                count = i;
                break;
            }   
        }
        if (count == -1)
        {
            printf("Player not found.\n");
            return;
        }

        
        printf("Update .......:\n");
        printf("(1)Matched Played\n");
        printf("(2)Runs Scored \n");
        printf("(3)Wickets\n");
        scanf("%d",&up_choice);

        if (up_choice == 1)
        {   
            printf("Enter the Number of Matched Played by the Player:\n");
            scanf("%d",&p[count].match_played);
            p_update = 1;
        }
        
        else if (up_choice == 2)
        {
            printf("Enter the Runs Scored by the Player:\n");
            scanf("%d",&p[count].runs);
            p_update = 1;
        }
        
        else if (up_choice == 3)
        {
            printf("Enter the JWicket taken by the Player:\n");
            scanf("%d",&p[count].wicket);
            p_update = 1;
        }

        else
        {
            printf("Invalid Choice.\n");
        }
      
        if (p_update == 1)
        {
            printf("Done : New details of the Player of Jersey Number: %d is updated.\n", p[count].jersey_num); 
        }  
        else
        {
            printf("ERROR : Player with Jersey Number %d is not Found!!!.\n", p[count].jersey_num);
        }     
    }
    else if (choice == 2)
    {
        printf("Enter the Name of the Player:");
        scanf("%s",name);

        for ( int i = 0; i < size; i++)
        {
            if (strcmp(p[i].player_name, name) == 0)
            {
                count = i;
                break;
            }   
        }
               
        if (count == -1)
        {
            printf("Player not found.\n");
            return;
        }


        printf("What do you want to Update:\n");
        printf("(1)Matched Played\n");
        printf("(2)Runs Scored \n");
        printf("(3)Wickets\n");
        scanf("%d",&up_choice);

        if (up_choice == 1)
        {   
            printf("Enter the Number of Matched Played by the Player:\n");
            scanf("%d",&p[count].jersey_num);
            p_update = 1;
        }
        
        else if (up_choice == 2)
        {
            printf("Enter the Runs Scored by the Player:\n");
            scanf("%d",&p[count].runs);
            p_update = 1;
        }
        
        else if (up_choice == 3)
        {
            printf("Enter the JWicket taken by the Player:\n");
            scanf("%d",&p[count].wicket);
            p_update = 1;
        }
    
        else
        {
            printf("Invalid Choice.\n");
        }
      
        if (p_update == 1)
        {
            printf("Done : New details of the Player of Jersey Number: %s is updated.\n", p[count].player_name); 
        }  
        else
        {
            printf("ERROR : Player with Jersey Number %s is not Found!!!.\n", p[count].player_name);
        }    
    }
    else
    {
        printf("Invalid search option.\n");
    }
}

void top_3(player* p, int size)
{   
    int choice;
    printf("Select among the following to find Top 3:\n");
    printf("(1)Batsmen with most runs.\n");
    printf("(2)Bowlers with most wickets.\n");
    printf("(3)Batsmen with least runs.\n");
    printf("(4)Bowlers with least wickets.\n");
    printf("(5)Show All\n");
    scanf("%d",&choice);

    switch (choice)
    {
    case 1:
        {   
            player p2;
            for (int i = 0; i < size-1; i++)
            {
                for (int j = i+1; j < size; j++)
                {
                    if (p[i].runs < p[j].runs)
                    {
                        p2 = p[i];
                        p[i] = p[j];
                        p[j] = p2;
                    }
                    
                }
                
            }
            for (int i = 0; i < 3; i++)
            {
                printf("\nBatsmen with most runs.\n");
                printf("Name      : %s\n", p[i].player_name);
                printf("Jersey no.: %d\n", p[i].jersey_num);
                printf("Runs      : %d\n", p[i].runs);
            }
                
        }
        break;
    case 2:
        {
            player p2;
            for (int i = 0; i < size-1; i++)
            {
                for (int j = i+1; j < size; j++)
                {
                    if (p[i].wicket < p[j].wicket)
                    {
                        p2 = p[i];
                        p[i] = p[j];
                        p[j] = p2;
                    }
                    
                }
                
            }
            for (int i = 0; i < 3; i++)
            {
                printf("\nBowlers with most wickets.\n");
                printf("Name      : %s\n", p[i].player_name);
                printf("Jersey no.: %d\n", p[i].jersey_num);
                printf("Wickets   : %d\n", p[i].wicket);
            }
        }      
        break;

    case 3:
        {
            player p2;
            for (int i = 0; i < size-1; i++)
            {
                for (int j = i+1; j < size; j++)
                {
                    if (p[i].runs > p[j].runs)
                    {
                        p2 = p[i];
                        p[i] = p[j];
                        p[j] = p2;
                    }
                    
                }
                
            }
            for (int i = 0; i < 3; i++)
            {
                printf("\nBatsmen with least runs.\n");
                printf("Name      : %s\n", p[i].player_name);
                printf("Jersey no.: %d\n", p[i].jersey_num);
                printf("Runs      : %d\n", p[i].runs);
            }
        }      
        break;

    case 4:
        {
            player p2;
            for (int i = 0; i < size-1; i++)
            {
                for (int j = i+1; j < size; j++)
                {
                    if (p[i].runs > p[j].runs)
                    {
                        p2 = p[i];
                        p[i] = p[j];
                        p[j] = p2;
                    }
                    
                }
                
            }
            for (int i = 0; i < 3; i++)
            {
                printf("\nBowlers with least wickets.\n");
                printf("Name      : %s\n", p[i].player_name);
                printf("Jersey no.: %d\n", p[i].jersey_num);
                printf("Runs      : %d\n", p[i].runs);
            }
        }      
        break;

    case 5:
        {
            player m_runs[size];
            player m_wickets[size];
            player l_runs[size];
            player l_wickets[size];

            for (int i = 0; i < size; i++)
            {
                m_runs[i] = p[i];
                m_wickets[i] = p[i];
                l_runs[i] = p[i];
                l_wickets[i] = p[i];
            }

            player temp;

            for (int i = 0; i < size - 1; i++)
            {
                for (int j = i + 1; j < size; j++)
                {
                    if (m_runs[i].runs < m_runs[j].runs)
                    {
                        temp = m_runs[i];
                        m_runs[i] = m_runs[j];
                        m_runs[j] = temp;
                    }
                }
            }

            for (int i = 0; i < size - 1; i++)
            {
                for (int j = i + 1; j < size; j++)
                {
                    if (m_wickets[i].wicket < m_wickets[j].wicket)
                    {
                        temp = m_wickets[i];
                        m_wickets[i] = m_wickets[j];
                        m_wickets[j] = temp;
                    }
                }
            }

            for (int i = 0; i < size - 1; i++)
            {
                for (int j = i + 1; j < size; j++)
                {
                    if (l_runs[i].runs > l_runs[j].runs)
                    {
                        temp = l_runs[i];
                        l_runs[i] = l_runs[j];
                        l_runs[j] = temp;
                    }
                }
            }

   
            for (int i = 0; i < size - 1; i++)
            {
                for (int j = i + 1; j < size; j++)
                {
                    if (l_wickets[i].wicket > l_wickets[j].wicket)
                    {
                        temp = l_wickets[i];
                        l_wickets[i] = l_wickets[j];
                        l_wickets[j] = temp;
                    }
                }
            }

    
            int limit = size < 3 ? size : 3;


            printf("\n===== TOP %d BATSMEN - MOST RUNS =====\n", limit);

            for (int i = 0; i < limit; i++)
            {
                printf("\nRank %d\n", i + 1);
                printf("Name      : %s\n", m_runs[i].player_name);
                printf("Jersey No.: %d\n", m_runs[i].jersey_num);
                printf("Runs      : %d\n", m_runs[i].runs);
            }

            printf("\n===== TOP %d BOWLERS - MOST WICKETS =====\n", limit);

            for (int i = 0; i < limit; i++)
            {
                printf("\nRank %d\n", i + 1);
                printf("Name      : %s\n", m_wickets[i].player_name);
                printf("Jersey No.: %d\n", m_wickets[i].jersey_num);
                printf("Wickets   : %d\n", m_wickets[i].wicket);
            }


            printf("\n===== TOP %d BATSMEN - LEAST RUNS =====\n", limit);

            for (int i = 0; i < limit; i++)
            {
                printf("\nRank %d\n", i + 1);
                printf("Name      : %s\n", l_runs[i].player_name);
                printf("Jersey No.: %d\n", l_runs[i].jersey_num);
                printf("Runs      : %d\n", l_runs[i].runs);
            }


            printf("\n===== TOP %d BOWLERS - LEAST WICKETS =====\n", limit);

            for (int i = 0; i < limit; i++)
            {
                printf("\nRank %d\n", i + 1);
                printf("Name      : %s\n", l_wickets[i].player_name);
                printf("Jersey No.: %d\n", l_wickets[i].jersey_num);
                printf("Wickets   : %d\n", l_wickets[i].wicket);
            }

        }
        break;  

    default:
        printf("Invalid Choice.");
        break;
    }

}

int main()
{   
    int arr_size;
    int  count = 0;
    int choice;
    printf("Enter the number of Player details you want to enter:");
    scanf("%d",&arr_size);
    player* p = malloc (arr_size * sizeof(player));
    if (p == NULL)
    {
        printf("Memory allocation failed.\n");
        return 1;
    }

    // int arr_size = 5;
    // int count = 5;

    // player p[5] = 
    // {
    //     {"Virat", 18, 250, 12898, 4},
    //     {"Rohit", 45, 243, 10500, 9},
    //     {"Bumrah", 93, 150, 350, 310},
    //     {"Jadeja", 8, 200, 3200, 280},
    //     {"Pant", 17, 120, 4200, 5}
    // };



    int i = 0;
    while(i == 0)
    {
        printf("\n");
        printf("Menu (Enter no. to select from the Menu):\n");
        
        printf("(1)Create\n");
        printf("(2)Display\n");
        printf("(3)Search\n");
        printf("(4)Update\n");
        printf("(5)Delete\n");
        printf("(6)Show Top 3 Palyers\n");
        printf("(7)Exit the Menu\n");

        scanf("%d",&choice);
        printf("\n");

        switch (choice)
        {
        case 1:
            count = store(p, count, arr_size);
            break;

        case 2:
            display(p, count);
            break;

        case 3:
            search(p, count);
            break;

        case 4:
            update(p, count);
            break;

        case 5:
            delete(p, &count);
            break;

        case 6:
            top_3(p, count);
            break;

        case 7:
            i = 1;
            printf("Exiting the Menu.......");
            break;
            
        default:
            printf("Invalid Option Selected.");
            break;
        }
    }
    free(p);
    return 0;
}