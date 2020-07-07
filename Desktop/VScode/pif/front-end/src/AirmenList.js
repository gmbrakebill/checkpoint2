import React from 'react';
import Airmen from './Airmen';
// import NewAirmen from './NewAirmen';

import {
    Route,
    Link
} from 'react-router-dom'

function AirmenList({airmen, parent})
{
    return (
        <div>
            {/* <Link to = "/airmen/new">New Airmen</Link> */}
            <Route exact path = "/airmen"><div>
            <div className="center">
                {airmen.map(airman => <Airmen id = {airman.amn_id} rank = {airman.rank} first_name = {airman.first_name} last_name = {airman.last_name}/> )}
                </div></div></Route>

                {/* <Route path = "/airmen/new" render={props => <NewAirmen {...props} grandparent={parent} />} /> */}
        </div>
    )
}
export default AirmenList