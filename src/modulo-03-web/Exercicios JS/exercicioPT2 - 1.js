var brewdog = function(string1, string2){
					var leng1 = string1.length;
					var leng2 = string2.length;
					var lengFor;
					diferenca = 0;
					diferentes = 0;
					
					lengFor = leng1;
					if(leng1 > leng2){lengFor = leng2;
					                  diferenca = leng1 - leng2;}
					else if(leng1 < leng2){diferenca = leng2 - leng1;}
					
					for(i = 0; i < lengFor; i++)
					{                        
						if(string1[i] !== string2[i])
						{
							diferentes++;
						}
					}
					
					diferentes += diferenca;
					
					return diferentes;
				};