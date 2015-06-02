using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dia01.ConsoleApp
{
    class Program
    {
        string _variavel;


        static void Main(string[] args)
        {
            #region dynamic
            dynamic oi = "Ta se loco!";
            oi += 10;
            #endregion

            #region Arraiiii

            var numeros = new[] { 1, 2, 3, 4 }.ToList();
            numeros.Add(5);



            /*for (int i = 0; i < 10000; i++) {
                Console.WriteLine(i);
            }*/

            foreach (var i in numeros)
            {
                Console.WriteLine(i);
            }

            Action<int> imprimir = i => Console.WriteLine(i + "bacon!");
            numeros.ForEach(imprimir);
            new[] { 5, 6, 7 }.ToList().ForEach(imprimir);

            #endregion

            #region Extension Methods

            Console.WriteLine("Ana".ToBacon());

            #endregion


            #region Jedi

            var yoda = new Jedi
            {
                Nome = "Yoda",
                Grau = Grau.MESTRE
            };
            

            Console.WriteLine(yoda.Nome);

            #endregion

            Console.ReadKey();
        }
    }
}
