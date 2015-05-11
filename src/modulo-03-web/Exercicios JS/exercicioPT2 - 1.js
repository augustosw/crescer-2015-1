var brewdog = function(string1, string2){
					var lengFor = Math.max(string1.length, string2.length);
					diferentes = 0;
					
					for(i = 0; i < lengFor; i++)
					{                        
						if(string1[i] !== string2[i])
						{
							diferentes++;
						}
					}					
					
					return diferentes;
				};